package com.edafa.demo.security;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.edafa.demo.security.AppUserPermissions.*;

public enum AppUserRole {
    STUDENT(Sets.newHashSet(COURSE_READ)),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));

    private Set<AppUserPermissions> permissions;

    AppUserRole(HashSet permissions) {
        this.permissions=permissions;
    }

    public Set<AppUserPermissions> getPermissions() {
        return permissions;
    }
}
