/*
 *  Copyright (c) 2020, 2021 Microsoft Corporation
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

package org.eclipse.dataspaceconnector.spi.system;

import org.eclipse.dataspaceconnector.spi.audit.AuditLogger;


/**
 * Contributes a {@link AuditLogger} to the system during bootstrap.
 */
public interface AuditExtension extends SystemExtension {

    /**
     * Returns the system monitor.
     */
    AuditLogger getAudit();

}
