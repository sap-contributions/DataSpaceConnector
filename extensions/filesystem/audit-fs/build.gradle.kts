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
 *      SAP SE - initial API and implementation
 *
 */

plugins {
    `java-library`
    `maven-publish`
}


dependencies {
    api(project(":spi"))
    implementation(project(":common:util"))
}

publishing {
    publications {
        create<MavenPublication>("filesystem-audit") {
            artifactId = "filesystem-audit"
            from(components["java"])
        }
    }
}
