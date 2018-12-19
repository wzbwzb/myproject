/*
 * Copyright © 2015-2026 the original author or authors.
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
 * @since 0.0.1
 */

package com.myproject.demo.Dto;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

@Data
public class TodayThingsResponse {

    private  String code;

    private  String msg;

    private JSONArray data;

    /**
     * 分页总数据
     */
    private long total;

    /**
     * 分页页码
     */
    private int pageNum;

    /**
     * 分页条数
     */
    private int pageSize;
}
