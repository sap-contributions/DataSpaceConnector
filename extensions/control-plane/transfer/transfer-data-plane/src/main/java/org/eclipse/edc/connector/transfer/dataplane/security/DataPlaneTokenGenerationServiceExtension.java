/*
 *  Copyright (c) 2023 SAP SE
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       SAP SE - initial API and implementation
 *
 */

package org.eclipse.edc.connector.transfer.dataplane.security;

import org.eclipse.edc.connector.transfer.dataplane.spi.security.KeyPairWrapper;
import org.eclipse.edc.jwt.TokenGenerationServiceImpl;
import org.eclipse.edc.jwt.spi.DataPlaneTokenGenerationService;
import org.eclipse.edc.runtime.metamodel.annotation.Extension;
import org.eclipse.edc.runtime.metamodel.annotation.Inject;
import org.eclipse.edc.runtime.metamodel.annotation.Provider;
import org.eclipse.edc.spi.system.ServiceExtension;
import org.eclipse.edc.spi.system.ServiceExtensionContext;

/*
 this extension creates and provides the default DataPlaneTokenGenerationService
 */

@Extension(value = DataPlaneTokenGenerationServiceExtension.NAME)
public class DataPlaneTokenGenerationServiceExtension implements ServiceExtension {
    public static final String NAME = "DataPlane TokenGenerationService Extension";
    @Inject
    private KeyPairWrapper keyPairWrapper;
    private DataPlaneTokenGenerationService defaultDataPlaneTokenGenerationService;

    public void initialize(ServiceExtensionContext context) {
        var tokenGenerationService = new TokenGenerationServiceImpl(keyPairWrapper.get().getPrivate());
        defaultDataPlaneTokenGenerationService = new DefaultDataPlaneTokenGenerationServiceImpl(tokenGenerationService);
    }

    @Provider(isDefault = true)
    public DataPlaneTokenGenerationService dataPlaneTokenGenerationService() {
        return defaultDataPlaneTokenGenerationService;
    }

}
