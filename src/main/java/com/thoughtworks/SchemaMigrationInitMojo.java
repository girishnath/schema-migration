package com.thoughtworks;


import org.apache.ibatis.migration.Migrator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which initializes a db
 *
 * @goal init
 * @phase initialize
 */
public class SchemaMigrationInitMojo extends AbstractMojo {

    /**
     * @parameter
     */
    private String environment;

    /**
     * @parameter
     */
    private String path;

    public void execute() throws MojoExecutionException {
        String[] args = {"init", "--env=" + environment, "--path=" + path};
        try {
            Migrator.main(args);
        } catch (Exception e) {
            throw new MojoExecutionException("Error running Schema Migration", e);
        }
    }
}
