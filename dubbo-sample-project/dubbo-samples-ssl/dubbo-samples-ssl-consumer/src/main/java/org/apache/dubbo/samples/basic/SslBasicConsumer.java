package org.apache.dubbo.samples.basic;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.SslConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.samples.basic.api.DemoService;
import org.springframework.core.io.ClassPathResource;

/**
 * @author tian
 */
public class SslBasicConsumer {

    private static final String ROOT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        SslConfig sslConfig = new SslConfig();
        if (args.length > 0) {
            if (args.length != 1 && args.length != 3) {
                System.out.println(
                        "USAGE: BasicConsumer [trustCertCollectionFilePath [certChainFilePath privateKeyFilePath]]\n " +
                                "Specify 'certChainFilePath' and 'privateKeyFilePath' only if you need Mutual TLS.");
                System.exit(0);
            }

            switch (args.length) {
                case 1:
                    sslConfig.setClientTrustCertCollectionPath(args[0]);
                    break;
                case 3:
                    sslConfig.setClientTrustCertCollectionPath(args[0]);
                    sslConfig.setClientKeyCertChainPath(args[1]);
                    sslConfig.setClientPrivateKeyPath(args[2]);
            }
        }

        DubboBootstrap bootstrap = DubboBootstrap.getInstance()
                .application(new ApplicationConfig("first-dubbo-consumer"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .ssl(sslConfig);

        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        reference.setInterface(DemoService.class);

        bootstrap.reference(reference);

        bootstrap.start();

        DemoService service = bootstrap.getCache().get(reference);
        String message = service.sayHello("dubbo");
        System.out.println(message);
    }
}