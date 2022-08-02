/*
 *  Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
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

package org.eclipse.dataspaceconnector.audit.fs;

import org.eclipse.dataspaceconnector.common.configuration.ConfigurationFunctions;
import org.eclipse.dataspaceconnector.spi.EdcSetting;
import org.eclipse.dataspaceconnector.spi.audit.AuditLogger;
import org.eclipse.dataspaceconnector.spi.system.AuditExtension;

/**
 * Extension adding file system audit log
 */
public class FsAuditLoggerExtension implements AuditExtension {

    @EdcSetting
    private static final String CONFIG_LOCATION = ConfigurationFunctions.propOrEnv("edc.fs.audit", "audit.log");

    @Override
    public AuditLogger getAudit() {
        return new FsAuditLogger(CONFIG_LOCATION);
    }
}
