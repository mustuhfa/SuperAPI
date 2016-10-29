package com.superapi.config;


import io.dropwizard.Bundle;
import io.dropwizard.servlets.assets.AssetServlet;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * A bundle for serving static asset files from the classpath.
 */
public class AssetsBundle implements Bundle {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssetsBundle.class);

    private final String resourcePath;
    private final String uriPath;
    private final String indexFile;
    private final String assetsName;

    /**
     * Creates a new AssetsBundle which will configure the application to serve the static files
     * located in {@code src/main/resources/${resourcePath}} as {@code /${uriPath}}. If no file name is
     * in ${uriPath}, ${indexFile} is appended before serving. For example, given a
     * {@code resourcePath} of {@code "/assets"} and a uriPath of {@code "/js"},
     * {@code src/main/resources/assets/example.js} would be served up from {@code /js/example.js}.
     *
     * @param resourcePath        the resource path (in the classpath) of the static asset files
     * @param uriPath             the uri path for the static asset files
     * @param indexFile           the name of the index file to use
     * @param assetsName          the name of servlet mapping used for this assets bundle
     */
    public AssetsBundle(String resourcePath, String uriPath, String indexFile, String assetsName) {
        checkArgument(resourcePath.startsWith("/"), "%s is not an absolute path", resourcePath);
        checkArgument(!"/".equals(resourcePath), "%s is the classpath root", resourcePath);
        this.resourcePath = resourcePath.endsWith("/") ? resourcePath : (resourcePath + '/');
        this.uriPath = uriPath.endsWith("/") ? uriPath : (uriPath + '/');
        this.indexFile = indexFile;
        this.assetsName = assetsName;
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        // nothing doing
    }

    @Override
    public void run(Environment environment) {
        LOGGER.info("Registering AssetBundle with name: {} for path {}", assetsName, uriPath + '*');
        environment.servlets().addServlet(assetsName, createServlet()).addMapping(uriPath + '*');
    }

    protected AssetServlet createServlet() {
        return new AssetServlet(resourcePath, uriPath, indexFile, StandardCharsets.UTF_8);
    }
}