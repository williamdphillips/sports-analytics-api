// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.phillips.sportsanalytics.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "azure.cosmos")
@Data
public class CosmosProperties {

    private String uri;

    private String key;

    private String secondaryKey;

    private String database;

    private boolean queryMetricsEnabled;
}