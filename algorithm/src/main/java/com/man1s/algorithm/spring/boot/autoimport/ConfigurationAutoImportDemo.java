package com.man1s.algorithm.spring.boot.autoimport;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ConfigurationAutoImportDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext configApplicationContext =
        new AnnotationConfigApplicationContext(ColorConfig.class);
    String[] beanDefinitionNames = configApplicationContext.getBeanDefinitionNames();
    Stream.of(beanDefinitionNames).forEach(System.out::println);

  }

}

@Import({Black.class,Config.class,ConfigSelectImport.class,ConfigRegistrar.class})
class ColorConfig{
}

class Black{

}

class Config{
  @Bean
  private Red red(){
    return new Red();
  }
  static class Red{

  }
}

class ConfigSelectImport implements ImportSelector{

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{Blue.class.getName()};
  }

  static class Blue{

  }
}

class ConfigRegistrar implements ImportBeanDefinitionRegistrar{

  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
      BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
      registry.registerBeanDefinition("yellow",new RootBeanDefinition(Yellow.class));
  }
  static class  Yellow{

  }
}
