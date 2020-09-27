package com.marco.mymall.admin.bo;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Data
public class UserTree {
    private Integer id;
    private Integer parentId;
    private String name;
    private String weight;
    private List<UserTree> children;
}
