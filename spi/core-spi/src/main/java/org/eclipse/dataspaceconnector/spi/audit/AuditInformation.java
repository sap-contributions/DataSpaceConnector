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

package org.eclipse.dataspaceconnector.spi.audit;

public class AuditInformation {

    private final String event;
    private final String username;
    private final String source;
    private final String auditText;

    public AuditInformation(String event, String username, String source, String auditText) {
        this.event = event;
        this.username = username;
        this.source = source;
        this.auditText = auditText;
    }

    public String getUsername() {
        return username;
    }

    public String getSource() {
        return source;
    }

    public String getAuditText() {
        return auditText;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "{event='" + event + '\'' +
                ", username='" + username + '\'' +
                ", source='" + source + '\'' +
                ", auditText='" + auditText + '\'' +
                '}';
    }
}
