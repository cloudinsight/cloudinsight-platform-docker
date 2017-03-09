打包:

>  mvn clean compile assembly:single   

Producer 启动:
> java -cp target/*.jar com.bin.kafkaSend.SenderTest      