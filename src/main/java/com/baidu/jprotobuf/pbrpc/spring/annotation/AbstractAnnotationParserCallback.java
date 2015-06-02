/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.jprotobuf.pbrpc.spring.annotation;

import com.baidu.jprotobuf.pbrpc.spring.PlaceholderResolver;
import com.baidu.jprotobuf.pbrpc.utils.StringUtils;


/**
 * Base annotation parser call back class.
 * 
 * @author xiemalin
 * @since 2.17
 */
public abstract class AbstractAnnotationParserCallback implements
        AnnotationParserCallback {

    
    /**
     * configuration resource placeholder resolver
     */
    private PlaceholderResolver resolver;
    
    /**
     * do parser action.
     * 
     * @param value to parser
     * @return value parser by {@link PlaceholderResolver}
     */
    public String parsePlaceholder(String value) {
        if (resolver != null) {
            return resolver.doParse(value);
        }
        return value;
    }
    
    /**
     * test if value contains placeholder marked string
     * 
     * @param value to test
     * @return true if string is null or contains placeholder marked string
     */
    public boolean hasPlaceholder(String value) {
        if (StringUtils.isBlank(value)) { 
            return false;
        }
        if (resolver != null) {
            return resolver.hasPlaceHolder(value);
        }
        return false;
    }
    
    /**
     * set PlaceholderResolver
     * @param resolver PlaceholderResolver 
     */
    public void setPlaceholderResolver(PlaceholderResolver resolver) {
        this.resolver = resolver;
    }

}
