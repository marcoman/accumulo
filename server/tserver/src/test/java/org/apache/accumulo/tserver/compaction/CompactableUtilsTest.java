/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.accumulo.tserver.compaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.accumulo.core.metadata.ReferencedTabletFile;
import org.apache.accumulo.server.tablets.TabletNameGenerator;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

public class CompactableUtilsTest {

  @Test
  public void testEquivalence() {
    ReferencedTabletFile expected = new ReferencedTabletFile(
        new Path("hdfs://localhost:8020/accumulo/tables/2a/default_tablet/F0000070.rf"));
    ReferencedTabletFile tmpFile =
        new ReferencedTabletFile(new Path(expected.getNormalizedPathStr() + "_tmp"));
    ReferencedTabletFile dest = TabletNameGenerator.computeCompactionFileDest(tmpFile);
    assertEquals(expected, dest);
  }

}
