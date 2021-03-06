#
# Copyright 2015 Naver Corp.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

import os
import Util, Conf

Logs = set()

def createlog(path):
  if Conf.USE_MEM_LOG:
    os.system('%s createlog %s' % (Conf.LOG_UTIL_BIN_PATH, path))
    Logs.add(path)

def syncdeletelog(path):
  if path in Logs:
    os.system('%s synclog %s' % (Conf.LOG_UTIL_BIN_PATH, path))
    os.system('%s deletelog %s' % (Conf.LOG_UTIL_BIN_PATH, path))
    Logs.discard(path)

def atExit():
  while len(Logs) > 0:
    path = Logs.pop()
    os.system('%s deletelog %s' % (Conf.LOG_UTIL_BIN_PATH, path))
