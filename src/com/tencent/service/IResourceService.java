package com.tencent.service;

import com.tencent.model.Activity;
import com.tencent.model.Project;
import com.tencent.model.Resource;
import com.tencent.model.User;

public interface IResourceService extends IService<Resource> {
//中间表如何处理待定

    public Resource implementResource(Activity activity, String title);

    public Resource borrowBooks(User user, String title);

    public Resource implementResource(Project project, String title);

    public void returnResource(User user, Resource resource);

    public void returnResource(Project project, Resource resource);

    public void returnResource(Activity activity, Resource resource);

	public Resource findBytitle(String title);
}
