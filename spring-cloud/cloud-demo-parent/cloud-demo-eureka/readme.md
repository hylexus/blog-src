
```shell
 127.0.0.1	localhost eureka-server-01 eureka-server-02 eureka-server-03
 
 java -jar target/cloud-demo-eureka.jar --eureka.instance.hostname=eureka-server-01 --server.port=7001
 java -jar target/cloud-demo-eureka.jar --eureka.instance.hostname=eureka-server-02 --server.port=7002
 java -jar target/cloud-demo-eureka.jar --eureka.instance.hostname=eureka-server-03 --server.port=7003
```