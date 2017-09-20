/*
 * mxisd - Matrix Identity Server Daemon
 * Copyright (C) 2017 Maxime Dor
 *
 * https://max.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.mxisd.storage.ormlite.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import io.kamax.mxisd.ThreePid;
import io.kamax.mxisd.storage.dao.IThreePidSessionDao;

@DatabaseTable(tableName = "session_3pid")
public class ThreePidSessionDao implements IThreePidSessionDao {

    @DatabaseField(id = true)
    private String id;

    @DatabaseField(canBeNull = false)
    private String server;

    @DatabaseField(canBeNull = false)
    private String medium;

    @DatabaseField(canBeNull = false)
    private String address;

    @DatabaseField(canBeNull = false)
    private String secret;

    @DatabaseField(canBeNull = false)
    private int attempt;

    @DatabaseField
    private String nextLink;

    @DatabaseField(canBeNull = false)
    private String token;

    public ThreePidSessionDao() {
        // stub for ORMLite
    }

    public ThreePidSessionDao(IThreePidSessionDao session) {
        setId(session.getId());
        setServer(session.getServer());
        setMedium(session.getMedium());
        setAddress(session.getAddress());
        setSecret(session.getSecret());
        setAttempt(session.getAttempt());
        setNextLink(session.getNextLink());
        setToken(session.getToken());
    }

    public ThreePidSessionDao(ThreePid tpid, String secret) {
        setMedium(tpid.getMedium());
        setAddress(tpid.getAddress());
        setSecret(secret);
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Override
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }

    @Override
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}