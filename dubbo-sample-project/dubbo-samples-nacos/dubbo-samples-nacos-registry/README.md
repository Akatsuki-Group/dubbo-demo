## Steps to run the samples

1. Start Nacos locally

  ```
  cd src/main/resources/docker
  docker-compose up
  ```
  
2. Run Dubbo provider demo `org.apache.dubbo.samples.ProviderBootstrap.main`

3. Run Dubbo consumer demo `org.apache.dubbo.samples.ConsumerBootstrap.main`, verify that standard ouput has the following content on the consumer side:

   ```
   result: hello, nacos
   ```