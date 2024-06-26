/*
 *  Copyright (c) 2021 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - Initial implementation
 *
 */

package org.eclipse.edc.api.observability;

import org.eclipse.edc.boot.system.injection.ObjectFactory;
import org.eclipse.edc.junit.extensions.DependencyInjectionExtension;
import org.eclipse.edc.spi.system.ServiceExtensionContext;
import org.eclipse.edc.spi.system.health.HealthCheckService;
import org.eclipse.edc.spi.system.health.LivenessProvider;
import org.eclipse.edc.spi.system.health.ReadinessProvider;
import org.eclipse.edc.web.spi.WebService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(DependencyInjectionExtension.class)
class ObservabilityApiExtensionTest {

    private final WebService webService = mock();
    private final HealthCheckService healthService = mock();
    private ObservabilityApiExtension extension;

    @BeforeEach
    void setup(ServiceExtensionContext context, ObjectFactory factory) {
        context.registerService(WebService.class, webService);
        context.registerService(HealthCheckService.class, healthService);
        extension = factory.constructInstance(ObservabilityApiExtension.class);
    }

    @Test
    void initialize() {
        var contextMock = mock(ServiceExtensionContext.class);

        extension.initialize(contextMock);

        verify(webService).registerResource(isA(ObservabilityApiController.class));
        verify(healthService).addReadinessProvider(isA(ReadinessProvider.class));
        verify(healthService).addLivenessProvider(isA(LivenessProvider.class));
        verifyNoMoreInteractions(webService);
        verifyNoMoreInteractions(healthService);
    }
}
