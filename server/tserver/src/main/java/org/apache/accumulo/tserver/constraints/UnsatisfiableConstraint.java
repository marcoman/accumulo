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
package org.apache.accumulo.tserver.constraints;

import java.util.Collections;
import java.util.List;

import org.apache.accumulo.core.data.Mutation;
import org.apache.accumulo.core.data.constraints.Constraint;

public class UnsatisfiableConstraint implements Constraint {

  private final List<Short> violations;
  private final String vDesc;

  public UnsatisfiableConstraint(short vcode, String violationDescription) {
    this.violations = Collections.unmodifiableList(Collections.singletonList(vcode));
    this.vDesc = violationDescription;
  }

  @Override
  public List<Short> check(Environment env, Mutation mutation) {
    return violations;
  }

  @Override
  public String getViolationDescription(short violationCode) {
    return vDesc;
  }

}
