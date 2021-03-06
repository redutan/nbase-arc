/*
 * Copyright 2015 Naver Corp.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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

package com.navercorp.nbasearc.confmaster.server.cluster;

import com.navercorp.nbasearc.confmaster.heartbeat.HBRefData;
import com.navercorp.nbasearc.confmaster.repository.znode.NodeType;
import com.navercorp.nbasearc.confmaster.repository.znode.ZNode;

public interface HeartbeatTarget {

    int getVersion();

    String getPath();

    String getTargetOfHeartbeatPath();

    String getName();
    
    String getFullName();

    NodeType getNodeType();

    String getHB();

    String getClusterName();

    void setClusterName(String clusterName);

    String getView();

    void setState(String state, long state_timestamp);

    long getStateTimestamp();

    boolean isHBCResponseCorrect(String recvedLine);

    String getPingMsg();

    HBRefData getRefData();

    String getIP();

    int getPort();

    UsedOpinionSet getUsedOpinions();

    <T> ZNode<T> getZNode();

}
