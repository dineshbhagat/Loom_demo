Loom Demo repository
====================

This is the repository in which I push the demos I present along with my presentations about the Loom project.

You can learn more about the Loom project and download the early access builds here: http://jdk.java.net/loom/

You can find the slides of the talk we did with Rémi Forax here: https://speakerdeck.com/josepaumard/loom-nous-protegera-t-il-du-braquage-temporel and see the presentation here: https://youtu.be/wx7t69DylsI

You can find the slides of my [Devoxx UK](https://www.devoxx.co.uk/) talk here: https://speakerdeck.com/josepaumard/loom-is-blooming

The version of Loom you need to run the examples is `jdk-19-loom+6-625`.

The `runConfigurations` directory contains the run configurations you can use to run the various examples. They have been created using IntelliJ IDEA and may not be working with other IDEs. 

-----------------------------


Download java 20, however at 2023-04-01, `ExtentLocal(jdk.incubator.concurrent.ExtentLocal)` attribute was not available in java 20 standard jdk but in preview build.    
It took sometime to make this work in commandline and more time in intelliJ-idea.   
Same steps can be followed for [this](https://github.com/JosePaumard/2022_javaone-loom-livelab) preject as well.   

1. Download [java-20/21](https://adoptium.net/temurin/releases/?version=20) standard build or [preview build](https://jdk.java.net/21/)   
2. Add JVM areguments to commandline as well as in runConfiguration of intelliJ-idea `--enable-preview --add-modules jdk.incubator.concurrent --add-exports java.base/jdk.internal.vm=ALL-UNNAMED`    
To add it in maven, update pom.xml to     
```xml
    <properties>
        <maven.compiler.source>20</maven.compiler.source>
        <maven.compiler.target>20</maven.compiler.target>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <enablePreview>true</enablePreview>
                    <compilerArgs>
                        <arg>
                            --add-modules=jdk.incubator.concurrent
                        </arg>
                        <arg>
                            --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED
                        </arg>
                    </compilerArgs>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
and run `mvn clean install` --> do this after setting your java_home to java 20.   

3. Update java Compiler option in intellij-idea   
i. settings --> Build, Execution, Deployment --> Compiler --> Java Compiler --> intick "Use --release option for cross-compilation (Java 9 or later)   
ii. Under javac options --> additional command line parameters --> add this `--enable-preview --add-modules jdk.incubator.concurrent --add-exports java.base/jdk.internal.vm=ALL-UNNAMED`.   
iii. apply --> ok.  

4. rebuild the project and should work fine.  
