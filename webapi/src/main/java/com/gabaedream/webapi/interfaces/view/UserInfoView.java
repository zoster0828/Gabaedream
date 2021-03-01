package com.gabaedream.webapi.interfaces.view;

import com.gabaedream.webapi.domain.aggregate.UserAggregate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoView {
    UserAggregate userAggregate;
    public UserInfoView(UserAggregate userAggregate) {
        this.userAggregate = userAggregate;
    }
}
