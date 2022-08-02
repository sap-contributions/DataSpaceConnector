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

import com.github.javafaker.Faker;
import net.bytebuddy.build.ToStringPlugin;
import org.assertj.core.groups.Tuple;
import org.eclipse.dataspaceconnector.spi.audit.AuditLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


public class AuditLoggerTest {

    static Faker faker = new Faker();
    final String message = faker.lorem().sentence();

    String auditLogFileName = "audit.log";
    AuditLogger audit = new FsAuditLogger(auditLogFileName);

    @Test
    public void writeAuditLogToFile() {

        audit.log(message);

        String line = "";
        try {
            line = getLastLine(new BufferedReader(new FileReader(auditLogFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(line).isEqualTo(message);
    }

    private static String getLastLine(BufferedReader reader) throws IOException {
        String line = null;
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            line = nextLine;
        }
        return line;
    }
}
