package com.johnhunsley.user.domain;

import java.util.List;

/**
 * <p>
 *     Similar to a Spring Data JPA Page type this is defined here so that we can define functions which
 *     return Paged domain objects without any dependency on JPA or the underlying repository implementation
 * </p>
 * <p>
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * </p>
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 15/12/2016
 *         Time : 14:06
 */
public class Page<T> {

    private List<T> pagedItems;

    private long totalItems;

    private int totalPages;

    public Page() {}

    public Page(List<T> pagedItems, long totalItems, int totalPages) {
        this.pagedItems = pagedItems;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    public List<T> getPagedItems() {
        return pagedItems;
    }

    public void setPagedItems(List<T> pagedItems) {
        this.pagedItems = pagedItems;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
