/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package support;

/**
 * <p> Manifest constants for the MailReader application. </p>
 */
public final class Constants {

    // --- Tokens ----

    /**
     * <p> The token representing a "cancel" request. </p>
     */
    public static final String CANCEL = "cancel";

    /**
     * <p> The token representing a "create" task. </p>
     */
    public static final String CREATE = "Create";

    /**
     * <p> The application scope attribute under which our user database is
     * stored. </p>
     */
    public static final String DATABASE_KEY = "database";

    /**
     * <p> The token representing a "edit" task. </p>
     */
    public static final String DELETE = "Delete";

    /**
     * <p> The token representing a "edit" task. </p>
     */
    public static final String EDIT = "Edit";

    /**
     * <p> The session scope attribute under which the User object for the
     * currently logged in user is stored. </p>
     */
    public static final String USER_KEY = "user";
    
    /**
     * <p> The session scope attribute under which the Paper object
     * currently selected by our logged-in User is stored. </p>
     */
    public static final String PAPER_KEY = "paper";

}
