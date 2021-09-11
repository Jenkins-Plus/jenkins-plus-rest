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
    // 获取流水线执行历史
    List<BlueRun> res = blueOceanApi.runApi().runs("jenkins","env-test");
    // 根据历史获取流水线执行节点
    
    
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