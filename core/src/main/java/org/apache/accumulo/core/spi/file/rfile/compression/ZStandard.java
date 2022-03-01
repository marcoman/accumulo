/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.accumulo.core.spi.file.rfile.compression;

import com.google.auto.service.AutoService;

@AutoService(CompressionAlgorithmConfiguration.class)
public class ZStandard implements CompressionAlgorithmConfiguration {

  @Override
  public String getName() {
    return "zstd";
  }

  @Override
  public String getCodecClassName() {
    return "org.apache.hadoop.io.compress.ZStandardCodec";
  }

  @Override
  public String getCodecClassNameProperty() {
    return "io.compression.codec.zstd.class";
  }

  @Override
  public int getDefaultBufferSize() {
    return 64 * 1024;
  }

  @Override
  public String getBufferSizeProperty() {
    return "io.compression.codec.zstd.buffersize";
  }

  @Override
  public boolean cacheCodecsWithNonDefaultSizes() {
    return true;
  }

}