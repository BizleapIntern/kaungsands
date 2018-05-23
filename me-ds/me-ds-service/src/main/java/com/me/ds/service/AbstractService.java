package com.me.ds.service;

import com.me.commons.domain.enums.EntityType;

public interface AbstractService {
    public long getCount();
    public String getNextBoId(EntityType entityType);
    public String makeBoId(String prefix,int currentObjCount);
    public String makeBoId(EntityType entityType, int currentObjectCount);
}
