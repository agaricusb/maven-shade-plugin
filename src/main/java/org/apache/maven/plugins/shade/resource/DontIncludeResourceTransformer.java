package org.apache.maven.plugins.shade.resource;

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

import org.apache.maven.plugins.shade.relocation.Relocator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * A resource processor that prevents the inclusion of an arbitrary
 * resource into the shaded JAR.
 */
public class DontIncludeResourceTransformer
    implements ResourceTransformer
{
    String resource;

    public boolean canTransformResource( String r )
    {
        if ( r.endsWith( resource ) )
        {
            return true;
        }

        return false;
    }

    public void processResource( String resource, InputStream is, List<Relocator> relocators )
        throws IOException
    {
        // no op
    }

    public boolean hasTransformedResource()
    {
        return false;
    }

    public void modifyOutputStream( JarOutputStream os )
        throws IOException
    {
        // no op
    }
}
