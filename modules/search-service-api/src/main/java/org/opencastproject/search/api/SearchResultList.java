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


package org.opencastproject.search.api;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResultList {
  private final List<SearchResult> list;

  private final long totalhits;

  public SearchResultList(SearchHits hits) {
    list = Arrays.stream(hits.getHits())
        .map(SearchHit::getSourceAsMap)
        .map(SearchResult::rehydrate)
        .collect(Collectors.toUnmodifiableList());
    totalhits = hits.getTotalHits().value;
  }

  public List<SearchResult> getHits() {
    return list;
  }

  public long getTotalHits() {
    return totalhits;
  }

}
