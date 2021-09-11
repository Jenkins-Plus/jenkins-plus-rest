## 项目简介
    基于 jenkins-rest 依赖并进行扩展
    基于 jenkins blue ocean 插件,并对blue ocean 插件相关的api，通过rest方式对外暴露

## 依赖
```
    <dependency>
      <groupId>plus.jenkins</groupId>
      <artifactId>jenkins-plus-rest</artifactId>
      <version>X.Y.Z</version>
    </dependency>
```

## 使用
```
    JenkinsPlusClient client = JenkinsPlusClient.builder()
    .endPoint("http://127.0.0.1:8080") // Optional. Defaults to http://127.0.0.1:8080
    .credentials("admin:password") // Optional.
    .build();
    
    // 查询 jenkins下所有的流水线
    List<BluePipeline> res = client.api().pipelineApi().pipelines("jenkins");
    System.out.println(JSONUtil.toJsonStr(res));
    
```

## 重点API介绍
```
    // 根据组织 获取所有的流水线配置
    List<BluePipeline> res = blueOceanApi.pipelineApi().pipelines("jenkins");
    // 根据流水线名称获取执行历史
    List<BlueRun> res = blueOceanApi.runApi().runs("jenkins","env-test");
    // 根据runId获取流水线执行节点,如果含有分支，请传入分支名称
    List<BlueRunNode> res = blueOceanApi.runApi().nodes("jenkins","env-test","7");
    // 根据runId和nodeId获取该节点的执行步骤steps,如果含有分支，请传入分支名称
    List<BlueRunNodeStep> res = blueOceanApi.runApi().steps("jenkins","env-test","7","8");
    // 根据runId和nodeId和stepId获取该步骤的日志,如果含有分支，请传入分支名称
    String res = blueOceanApi.logApi().stepLog("jenkins","env-test","7","8","9");
    // 根据runId获取该次执行的完整日志,如果含有分支，请传入分支名称
    String res = blueOceanApi.logApi().fullLog("jenkins","env-test","7");
    
```

    
## 技术选型
    Java
    jenkins-rest
    jenkins blue ocean plugin
    
## 文档

* [jenkins-plus](https://www.jenkins.plus)
* [jenkins-rest](https://github.com/cdancy/jenkins-rest)
* [Jenkins REST API](http://wiki.jenkins-ci.org/display/JENKINS/Remote+access+API)
* [Apache jclouds](https://jclouds.apache.org/start/)

## FAQ
    开发过程中常见问题的解答。