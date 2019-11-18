package com.nfdw.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class Locking {
    private Integer lockingNumber;

    private Integer lockingMinute;

    public Integer getLockingNumber() {
        return lockingNumber;
    }

    public void setLockingNumber(Integer lockingNumber) {
        this.lockingNumber = lockingNumber;
    }

    public Integer getLockingMinute() {
        return lockingMinute;
    }

    public void setLockingMinute(Integer lockingMinute) {
        this.lockingMinute = lockingMinute;
    }
}
