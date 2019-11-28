package workmanager.service;

import workmanager.util.MyResult;

public interface FriendService {
    MyResult selectFriendByAddUserId(Integer addUserId);
}
