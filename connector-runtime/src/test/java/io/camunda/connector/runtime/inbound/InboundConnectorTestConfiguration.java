/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.camunda.connector.runtime.inbound;

import io.camunda.connector.runtime.inbound.operate.OperateClientLifecycle;
import io.camunda.operate.CamundaOperateClient;
import io.camunda.operate.exception.OperateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class InboundConnectorTestConfiguration {

  @Bean
  @Primary
  public OperateClientLifecycle operateClientLifecycle() throws OperateException {
    CamundaOperateClient camundaOperateClientMock = mock(CamundaOperateClient.class);
    when(camundaOperateClientMock.searchProcessDefinitions(any())).thenReturn(new ArrayList<>());
    return new OperateClientLifecycle(camundaOperateClientMock);
  }
}
