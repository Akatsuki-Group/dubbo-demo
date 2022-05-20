package org.apache.dubbo.samples;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * @author tian
 */
@Mojo(name = "local-address")
public class LocalAddressMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Parameter(name = "localAddress", defaultValue = "dubbo.local.address")
    private String localAddress;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String address = DubboLocalIpDetector.getAddress();
        getLog().info("set dubbo local address " + address + " to property '" + localAddress + "'");
        project.getProperties().setProperty(localAddress, DubboLocalIpDetector.getAddress());
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }
}
