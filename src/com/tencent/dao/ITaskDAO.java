package com.tencent.dao;

import com.tencent.model.Task;

public interface ITaskDAO extends IDao<Task> {

    public Task findByContent(String content);
}
