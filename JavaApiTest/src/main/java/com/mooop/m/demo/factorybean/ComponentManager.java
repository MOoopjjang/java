package com.mooop.m.demo.factorybean;
import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * Spring에 BeanFactory의 원리를 simple하게 구현한 객체
 *
 */
public class ComponentManager {

    /**
     * annotation의로 선언된 instance를 저장하는 map
     */
    private Map<String , Object> beanMap = new HashMap<>();

    private ComponentManager(){
        try{
            loadMComponent();
            loadMResource();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    /**
     * Singleton
     * @return
     */
    public static ComponentManager getInstance(){
        return LazyHolder.INSTANCE;
    }


    /**
     * bean 네임으로 객체 반환
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        if(beanMap.containsKey(beanName)){
            return beanMap.get(beanName);
        }
        return null;
    }


    /**
     * @MComponent annotation이 선언된 class를 찾아서 등록
     */
    private void loadMComponent(){
        MClassLoader mClassLoader = new MClassLoader();
        File[] files = getFiles();
        for(File f : files){
            try{
                Class loadClass = mClassLoader.findClass(f.getPath());
                if(!loadClass.getSimpleName().trim().equals("")
                    && !loadClass.getSimpleName().trim().equals("MComponent")
                    && !loadClass.getSimpleName().trim().equals("MResource")
                ){
                    Class cc = Class.forName(loadClass.getPackage().getName()+"."+loadClass.getSimpleName());
                    MComponent annotation = (MComponent) cc.getDeclaredAnnotation(MComponent.class);
                    if(annotation != null){
                        beanMap.put(annotation.value() , cc.newInstance());
                    }
                }
            }catch(Exception e){}
        }
    }


    /**
     * @MResource가 선언된 Field를 찾아서 객체 할당
     *   - @MComponent로 선언된 class에 들사이에만 @MResource 가 유효하다
     *
     */
    private void loadMResource() throws Exception{
        /** @MComponent로 선언된 객체들이 등록되지 않았을경우 등록 */
        if(beanMap.isEmpty()){
            loadMComponent();
        }

        if(beanMap.isEmpty()){
            throw new Exception("등록된 bean이 없습니다.");
        }

        MClassLoader mClassLoader = new MClassLoader();
        File[] files = getFiles();
            for(File file : files){
                try{
                   Class loadClass = mClassLoader.findClass(file.getPath());
                if(!loadClass.getSimpleName().trim().equals("")
                    && !loadClass.getSimpleName().trim().equals("MComponent")
                    && !loadClass.getSimpleName().trim().equals("MResource")
                ){
                    Class cc = Class.forName(loadClass.getPackage().getName()+"."+loadClass.getSimpleName());
                    Field[] fields = cc.getDeclaredFields();
                    for(Field field : fields){
                        MResource annotation = field.getDeclaredAnnotation(MResource.class);

                        if(annotation != null){

                            System.out.println(cc.getSimpleName());
                            /** 1. MResource Field를 포함한 class가 bean으로 등록된 class 인지 체크 */
                             String mComponentValue = Optional.ofNullable((MComponent) cc.getDeclaredAnnotation(MComponent.class))
                                .map(mComponent -> mComponent.value())
                                .orElseThrow(()->new Exception("bean으로 선언된 class에서만 MAutowired 속성사용이 가능합니다."));

                              System.out.println("mComponentValue =>"+mComponentValue);
                            String injectionName = annotation.name();
                            Object injectObject = beanMap.get(injectionName);
                            /** 2. MResource로 선언된 field class가 bean으로 등록되어 있는지 체크 */
                            if(injectObject == null){
                                throw new Exception(injectionName +"는 bean으로 선언된 class가 아닙니다.");
                            }

                            /** 3. bean factory ( beanMap )에서 field에 해당되는 객체를 가져와서 field에 할당한다.   */
                            Object classObject = beanMap.get(mComponentValue);
                            Field ff = classObject.getClass().getDeclaredField(field.getName());
                            ff.setAccessible(true);
                            ff.set(classObject , injectObject);
                        }
                    }
                }
                }catch(Exception e){

                }

        }
    }



    private File[] getFiles(){
         /**
         * Annotation이 선언된 class 미리 등록
         */

        String currentDir = "/Users/gimcheol-u/Documents/work/git/java/JavaApiTest/build/classes/java/main/com/mooop/m/demo/factorybean";
        File fDir = new File(currentDir);
        File[] files = fDir.listFiles((f , n)->n.endsWith(".class"));
        return files;
    }


    private static class LazyHolder{
        private static final ComponentManager INSTANCE = new ComponentManager();
    }
}
