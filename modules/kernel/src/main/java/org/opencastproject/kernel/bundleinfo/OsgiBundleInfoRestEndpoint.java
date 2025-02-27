/*
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 *
 * The Apereo Foundation licenses this file to you under the Educational
 * Community License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at:
 *
 *   http://opensource.org/licenses/ecl2.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.opencastproject.kernel.bundleinfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import javax.ws.rs.Path;

/** OSGi bound implementation. */
@Path("/sysinfo")
@Component(
    immediate = true,
    service = OsgiBundleInfoRestEndpoint.class,
    property = {
        "service.description=System BundleInfo REST Endpoint",
        "opencast.service.type=org.opencastproject.kernel.bundleinfo",
        "opencast.service.path=/sysinfo"
    }
)
@JaxrsResource
public class OsgiBundleInfoRestEndpoint extends BundleInfoRestEndpoint {
  private BundleInfoDb db;

  @Reference
  public void setDb(BundleInfoDb db) {
    this.db = db;
  }

  @Override
  protected BundleInfoDb getDb() {
    return db;
  }
}
