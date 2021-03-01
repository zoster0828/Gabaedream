package com.gabaedream.webapi.messenger.view.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class MessengerListParameter {

//    @NotNull() ,, javax add 필요
//    @ApiModelProperty(required = true)
    private Filter filter;
    private int limit;
    private int offset;


    @AllArgsConstructor
    @Getter
    public static enum Filter{
        CREATED_DESC("created_at DESC"),
        CREATED_ASC("created_at ASC"),
        MODIFED_DESC("modified_at DESC"),
        MODIFIED_ASC("modified_at ASC");

        private String filter;

    }
}
