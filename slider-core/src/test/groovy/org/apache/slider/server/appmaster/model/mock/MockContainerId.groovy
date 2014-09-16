/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.slider.server.appmaster.model.mock

import org.apache.hadoop.yarn.api.records.ApplicationAttemptId
import org.apache.hadoop.yarn.api.records.ContainerId

class MockContainerId extends ContainerId implements Cloneable {

  private static final defaultAppAttemptId = new MockApplicationAttemptId(
      new MockApplicationId(1), 1)
  
  long containerId;
  ApplicationAttemptId applicationAttemptId;

  MockContainerId() {
  }

  /**
   * Sets up a default app Attempt ID
   * @param containerId
   */
  @Deprecated
  MockContainerId(long containerId) {
    this.containerId = containerId;
    this.applicationAttemptId = defaultAppAttemptId;
  }

  MockContainerId(ApplicationAttemptId applicationAttemptId, long containerId) {
    this.containerId = containerId;
    this.applicationAttemptId = applicationAttemptId
  }
  
  MockContainerId(ContainerId that) {
    containerId = that.containerId
    applicationAttemptId = that.applicationAttemptId
  }
  

  int getId() {
    return (int) containerId
  }

  long getContainerId() {
    return this.containerId;
  }

  void setContainerId(long id) {
    this.containerId = id
  }

  ApplicationAttemptId getApplicationAttemptId() {
    return applicationAttemptId
  }

  void setApplicationAttemptId(ApplicationAttemptId applicationAttemptId) {
    this.applicationAttemptId = applicationAttemptId
  }

  @Override
  public void build() {

  }
  
  @Override
  public String toString() {
    return "mockcontainer_" + containerId;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone()
  }
}
