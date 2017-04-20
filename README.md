���򹤳�,��mybatis������Ŀʱ���Լ򻯿�����
�����ݿ������֮��,�����򹤳����ɶ����mapperӳ���ļ���

ͬѧ���и��ˣ�����һЩʱ�䣬����������һ����������Mybatis Generator�����MBG���������������ļ�������⣬��Ҳ����ȥ��EN��User Guide�ˣ�

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<!-- ���������� -->
<generatorConfiguration>
<!-- �������ڼ�����������������ļ��������������ļ��оͿ���ʹ��${propertyKey}�ķ�ʽ������������
    resource��������Դ���ص�ַ��ʹ��resource��MBG��classpath��ʼ�ң�����com/myproject/generatorConfig.properties        
    url��������Դ���ص��ʣ�ʹ��URL�ķ�ʽ������file:///C:/myfolder/generatorConfig.properties.
    ע�⣬��������ֻ��ѡַһ��;

    ���⣬���ʹ����mybatis-generator-maven-plugin����ô��pom.xml�ж����properties������ֱ����generatorConfig.xml��ʹ��
<properties resource="" url="" />
 -->

 <!-- ��MBG������ʱ����Ҫ������ص�������
     location����ָ������jar/zip����ȫ·��
<classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />
  -->

<!-- 
    context:����һ�����Ļ��� 
    id:��ѡ��������id�����������ɴ���ʱ��ʾ
    defaultModelType:ָ�����ɶ������ʽ
        1��conditional������hierarchical��
        2��flat���������ݣ�������blob����ȫ��������һ�������У�
        3��hierarchical����������һ��XXKey����(key class)��Blob�ȵ�������һ������������������һ��������(record class)
    targetRuntime:
        1��MyBatis3��Ĭ�ϵ�ֵ�����ɻ���MyBatis3.x���ϰ汾�����ݣ�����XXXBySample��
        2��MyBatis3Simple������MyBatis3��ֻ�ǲ�����XXXBySample��
    introspectedColumnImpl����ȫ�޶�����������չMBG
-->
<context id="mysql" defaultModelType="hierarchical" targetRuntime="MyBatis3Simple" >

    <!-- �Զ�ʶ�����ݿ�ؼ��֣�Ĭ��false���������Ϊtrue������SqlReservedWords�ж���Ĺؼ����б���
        һ�㱣��Ĭ��ֵ���������ݿ�ؼ��֣�Java�ؼ��֣���ʹ��columnOverride����
     -->
    <property name="autoDelimitKeywords" value="false"/>
    <!-- ���ɵ�Java�ļ��ı��� -->
    <property name="javaFileEncoding" value="UTF-8"/>
    <!-- ��ʽ��java���� -->
    <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter"/>
    <!-- ��ʽ��XML���� -->
    <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter"/>

    <!-- beginningDelimiter��endingDelimiter��ָ�����ݿ�����ڱ�����ݿ�������ķ��ţ�����ORACLE����˫���ţ�MYSQLĬ����`�����ţ� -->
    <property name="beginningDelimiter" value="`"/>
    <property name="endingDelimiter" value="`"/>

    <!-- ����Ҫ�еģ�ʹ����������������ݿ�
        @TODO:�Ƿ������չ
     -->
    <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql:///pss" userId="root" password="admin">
        <!-- �������������property���ԣ�ÿһ��property���Զ����õ����õ�Driver�� -->
    </jdbcConnection>

    <!-- java���ʹ����� 
        ���ڴ���DB�е����͵�Java�е����ͣ�Ĭ��ʹ��JavaTypeResolverDefaultImpl��
        ע��һ�㣬Ĭ�ϻ��ȳ���ʹ��Integer��Long��Short������ӦDECIMAL�� NUMERIC�������ͣ� 
    -->
    <javaTypeResolver type="org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl">
        <!-- 
            true��ʹ��BigDecimal��ӦDECIMAL�� NUMERIC��������
            false��Ĭ��,
                scale>0;length>18��ʹ��BigDecimal;
                scale=0;length[10,18]��ʹ��Long��
                scale=0;length[5,9]��ʹ��Integer��
                scale=0;length<5��ʹ��Short��
         -->
        <property name="forceBigDecimals" value="false"/>
    </javaTypeResolver>


    <!-- javaģ�ʹ��������Ǳ���Ҫ��Ԫ��
        ����1��key�ࣨ��context��defaultModelType����2��java�ࣻ3����ѯ��
        targetPackage�����ɵ���Ҫ�ŵİ�����ʵ�İ���enableSubPackages���Կ��ƣ�
        targetProject��Ŀ����Ŀ��ָ��һ�����ڵ�Ŀ¼�£����ɵ����ݻ�ŵ�ָ��Ŀ¼�У����Ŀ¼�����ڣ�MBG�����Զ���Ŀ¼
     -->
    <javaModelGenerator targetPackage="com._520it.mybatis.domain" targetProject="src/main/java">
        <!--  for MyBatis3/MyBatis3Simple
            �Զ�Ϊÿһ�����ɵ��ഴ��һ�����췽�������췽�����������е�field��������ʹ��setter��
         -->
        <property name="constructorBased" value="false"/>

        <!-- ��targetPackage�Ļ����ϣ��������ݿ��schema������һ��package���������ɵ���������package�£�Ĭ��Ϊfalse -->
        <property name="enableSubPackages" value="true"/>

        <!-- for MyBatis3 / MyBatis3Simple
            �Ƿ񴴽�һ�����ɱ���࣬���Ϊtrue��
            ��ôMBG�ᴴ��һ��û��setter�������࣬ȡ����֮��������constructorBased����
         -->
        <property name="immutable" value="false"/>

        <!-- ����һ��������
            ��������������������ô���ɵ�keyClass����recordClass��̳�����ࣻ��Table��rootClass�����п��Ը��Ǹ�ѡ��
            ע�⣺�����key class����record class����root class��ͬ�����ԣ�MBG�Ͳ�������������Щ�����ˣ�������
                1����������ͬ��������ͬ������ͬ��getter/setter������
         -->
        <property name="rootClass" value="com._520it.mybatis.domain.BaseDomain"/>

        <!-- �����Ƿ���getter�����У���String�����ֶε���trim()���� -->
        <property name="trimStrings" value="true"/>
    </javaModelGenerator>


    <!-- ����SQL map��XML�ļ���������
        ע�⣬��Mybatis3֮�����ǿ���ʹ��mapper.xml�ļ�+Mapper�ӿڣ����߲���mapper�ӿڣ���
            ����ֻʹ��Mapper�ӿ�+Annotation�����ԣ���� javaClientGenerator��������������Ҫ����XML�Ļ������Ԫ�ؾͱ�������
        targetPackage/targetProject:ͬjavaModelGenerator
     -->
    <sqlMapGenerator targetPackage="com._520it.mybatis.mapper" targetProject="src/main/resources">
        <!-- ��targetPackage�Ļ����ϣ��������ݿ��schema������һ��package���������ɵ���������package�£�Ĭ��Ϊfalse -->
        <property name="enableSubPackages" value="true"/>
    </sqlMapGenerator>


    <!-- ����mybatis��˵��������Mapper�ӿڣ�ע�⣬���û�����ø�Ԫ�أ���ôĬ�ϲ�������Mapper�ӿ� 
        targetPackage/targetProject:ͬjavaModelGenerator
        type��ѡ����ô����mapper�ӿڣ���MyBatis3/MyBatis3Simple�£���
            1��ANNOTATEDMAPPER��������ʹ��Mapper�ӿ�+Annotation�ķ�ʽ������SQL������annotation�У����������ɶ�Ӧ��XML��
            2��MIXEDMAPPER��ʹ�û�����ã�������Mapper�ӿڣ����ʵ����Ӻ��ʵ�Annotation������XML��������XML�У�
            3��XMLMAPPER��������Mapper�ӿڣ��ӿ���ȫ����XML��
        ע�⣬���context��MyBatis3Simple��ֻ֧��ANNOTATEDMAPPER��XMLMAPPER
    -->
    <javaClientGenerator targetPackage="com._520it.mybatis.mapper" type="ANNOTATEDMAPPER" targetProject="src/main/java">
        <!-- ��targetPackage�Ļ����ϣ��������ݿ��schema������һ��package���������ɵ���������package�£�Ĭ��Ϊfalse -->
        <property name="enableSubPackages" value="true"/>

        <!-- ����Ϊ�������ɵĽӿ�����һ�����ӿڣ�����MBGֻ�������ɣ���������
        <property name="rootInterface" value=""/>
         -->
    </javaClientGenerator>

    <!-- ѡ��һ��table����������ļ���������һ������table������Ҫ��tableԪ��
        ѡ���table������һ���ļ���
        1��SQL map�ļ�
        2������һ�������ࣻ
        3������BLOB�������������ֶε��ࣻ
        4������BLOB���ࣻ
        5��һ���û����ɶ�̬��ѯ�������ࣨselectByExample, deleteByExample������ѡ��
        6��Mapper�ӿڣ���ѡ��

        tableName����Ҫ����Ҫ���ɶ���ı�����
        ע�⣺��Сд�������⡣��������£�MBG���Զ���ȥʶ�����ݿ��ʶ���Ĵ�Сд���жȣ���һ������£�MBG��
            �������õ�schema��catalog��tablenameȥ��ѯ���ݱ���������������̣�
            1�����schema��catalog��tablename���пո���ô���õ���ʲô��ʽ���;�ȷ��ʹ��ָ���Ĵ�Сд��ʽȥ��ѯ��
            2������������ݿ�ı�ʶ��ʹ�ô�д�ģ���ôMBG�Զ��ѱ�����ɴ�д�ٲ��ң�
            3������������ݿ�ı�ʶ��ʹ��Сд�ģ���ôMBG�Զ��ѱ������Сд�ٲ��ң�
            4������ʹ��ָ���Ĵ�Сд��ʽ��ѯ��
        ����ģ�����ڴ�������ʱ��ʹ�õ�""�����ݿ����涨��Сд���������ݿ��ʶ����ʹ�õĴ�д�������������Ҳ��ʹ�ø����Ĵ�Сд������������
        ���ʱ��������delimitIdentifiers="true"���ɱ�����Сд��ʽ��

        ��ѡ��
        1��schema�����ݿ��schema��
        2��catalog�����ݿ��catalog��
        3��alias��Ϊ���ݱ����õı��������������alias����ô���ɵ����е�SELECT SQL����У��������ɣ�alias_actualColumnName
        4��domainObjectName�����ɵ�domain������֣���������ã�ֱ��ʹ�ñ�����Ϊdomain������֣���������Ϊsomepck.domainName����ô���Զ���domainName���ٷŵ�somepck�����棻
        5��enableInsert��Ĭ��true����ָ���Ƿ�����insert��䣻
        6��enableSelectByPrimaryKey��Ĭ��true����ָ���Ƿ����ɰ���������ѯ�������䣨����getById��get����
        7��enableSelectByExample��Ĭ��true����MyBatis3SimpleΪfalse��ָ���Ƿ����ɶ�̬��ѯ��䣻
        8��enableUpdateByPrimaryKey��Ĭ��true����ָ���Ƿ����ɰ��������޸Ķ������䣨��update)��
        9��enableDeleteByPrimaryKey��Ĭ��true����ָ���Ƿ����ɰ�������ɾ���������䣨��delete����
        10��enableDeleteByExample��Ĭ��true����MyBatis3SimpleΪfalse��ָ���Ƿ����ɶ�̬ɾ����䣻
        11��enableCountByExample��Ĭ��true����MyBatis3SimpleΪfalse��ָ���Ƿ����ɶ�̬��ѯ��������䣨���ڷ�ҳ����������ѯ����
        12��enableUpdateByExample��Ĭ��true����MyBatis3SimpleΪfalse��ָ���Ƿ����ɶ�̬�޸���䣨ֻ�޸Ķ����в�Ϊ�յ����ԣ���
        13��modelType���ο�contextԪ�ص�defaultModelType���൱�ڸ��ǣ�
        14��delimitIdentifiers���ο�tableName�Ľ��ͣ�ע�⣬Ĭ�ϵ�delimitIdentifiers��˫���ţ��������MYSQL���������ݿ⣬ʹ�õ���`�������ţ���ô����Ҫ����context��beginningDelimiter��endingDelimiter���ԣ�
        15��delimitAllColumns�������Ƿ��������ɵ�SQL�е�������ʹ�ñ�ʶ����������Ĭ��Ϊfalse��delimitIdentifiers�ο�context������

        ע�⣬table����ܶ�������Ƕ�javaModelGenerator��context��Ԫ�ص�Ĭ�����Ե�һ����д��
     -->
    <table tableName="userinfo" >

        <!-- �ο� javaModelGenerator �� constructorBased����-->
        <property name="constructorBased" value="false"/>

        <!-- Ĭ��Ϊfalse���������Ϊtrue�������ɵ�SQL�У�table���ֲ������catalog��schema�� -->
        <property name="ignoreQualifiersAtRuntime" value="false"/>

        <!-- �ο� javaModelGenerator �� immutable ���� -->
        <property name="immutable" value="false"/>

        <!-- ָ���Ƿ�ֻ����domain�࣬�������Ϊtrue��ֻ����domain�࣬�����������sqlMapGenerator����ô��mapper XML�ļ��У�ֻ����resultMapԪ�� -->
        <property name="modelOnly" value="false"/>

        <!-- �ο� javaModelGenerator �� rootClass ���� 
        <property name="rootClass" value=""/>
         -->

        <!-- �ο�javaClientGenerator ��  rootInterface ����
        <property name="rootInterface" value=""/>
        -->

        <!-- ���������runtimeCatalog����ô�����ɵ�SQL�У�ʹ�ø�ָ����catalog��������tableԪ���ϵ�catalog 
        <property name="runtimeCatalog" value=""/>
        -->

        <!-- ���������runtimeSchema����ô�����ɵ�SQL�У�ʹ�ø�ָ����schema��������tableԪ���ϵ�schema 
        <property name="runtimeSchema" value=""/>
        -->

        <!-- ���������runtimeTableName����ô�����ɵ�SQL�У�ʹ�ø�ָ����tablename��������tableԪ���ϵ�tablename 
        <property name="runtimeTableName" value=""/>
        -->

        <!-- ע�⣬������ֻ���MyBatis3Simple���ã�
            ���ѡ���runtime��MyBatis3Simple����ô������һ��SelectAll���������ָ����selectAllOrderByClause����ô���ڸ�SQL������ָ�������order������
         -->
        <property name="selectAllOrderByClause" value="age desc,username asc"/>

        <!-- �������Ϊtrue�����ɵ�model���ֱ��ʹ��column���������֣���������ʹ���շ���������������BORN_DATE�����ɵ��������־���BORN_DATE,��������bornDate -->
        <property name="useActualColumnNames" value="false"/>


        <!-- generatedKey�����������������ķ�����
            ��������˸�Ԫ�أ�MBG�������ɵ�<insert>Ԫ��������һ����ȷ��<selectKey>Ԫ�أ���Ԫ�ؿ�ѡ
            column:������������
            sqlStatement��Ҫ���ɵ�selectKey��䣬�����¿�ѡ�
                Cloudscape:�൱��selectKey��SQLΪ�� VALUES IDENTITY_VAL_LOCAL()
                DB2       :�൱��selectKey��SQLΪ�� VALUES IDENTITY_VAL_LOCAL()
                DB2_MF    :�൱��selectKey��SQLΪ��SELECT IDENTITY_VAL_LOCAL() FROM SYSIBM.SYSDUMMY1
                Derby      :�൱��selectKey��SQLΪ��VALUES IDENTITY_VAL_LOCAL()
                HSQLDB      :�൱��selectKey��SQLΪ��CALL IDENTITY()
                Informix  :�൱��selectKey��SQLΪ��select dbinfo('sqlca.sqlerrd1') from systables where tabid=1
                MySql      :�൱��selectKey��SQLΪ��SELECT LAST_INSERT_ID()
                SqlServer :�൱��selectKey��SQLΪ��SELECT SCOPE_IDENTITY()
                SYBASE      :�൱��selectKey��SQLΪ��SELECT @@IDENTITY
                JDBC      :�൱�������ɵ�insertԪ��������useGeneratedKeys="true"��keyProperty����
        <generatedKey column="" sqlStatement=""/>
         -->

        <!-- 
            ��Ԫ�ػ��ڸ��ݱ��������������������֮ǰ���������������ǳ��ʺ����ڱ��е��ж��й��õ�ǰ׺�ַ�����ʱ��
            ��������Ϊ��CUST_ID,CUST_NAME,CUST_EMAIL,CUST_ADDRESS�ȣ�
            ��ô�Ϳ�������searchStringΪ"^CUST_"����ʹ�ÿհ��滻����ô���ɵ�Customer�����е��������ƾͲ���
            custId,custName�ȣ������ȱ��滻ΪID,NAME,EMAIL,Ȼ�������ԣ�id��name��email��

            ע�⣬MBG��ʹ��java.util.regex.Matcher.replaceAll���滻searchString��replaceString�ģ�
            ���ʹ����columnOverrideԪ�أ���������Ч��

        <columnRenamingRule searchString="" replaceString=""/>
         -->


         <!-- �����޸ı���ĳ���е����ԣ�MBG��ʹ���޸ĺ����������domain�����ԣ�
             column:Ҫ�������õ�������
             ע�⣬һ��tableԪ���п����ж��columnOverrideԪ�ع�~
          -->
         <columnOverride column="username">
             <!-- ʹ��property������ָ����Ҫ���ɵ��������� -->
             <property name="property" value="userName"/>

             <!-- javaType����ָ�����ɵ�domain���������ͣ�ʹ�����͵�ȫ�޶���
             <property name="javaType" value=""/>
              -->

             <!-- jdbcType����ָ�����е�JDBC���� 
             <property name="jdbcType" value=""/>
              -->

             <!-- typeHandler ����ָ������ʹ�õ���TypeHandler�����Ҫָ�����������ʹ�������ȫ�޶���
                 ע�⣬mybatis�У��������ɵ�mybatis-config.xml�е�typeHandler
                 ֻ���������ƣ�where id = #{id,jdbcType=BIGINT,typeHandler=com._520it.mybatis.MyTypeHandler}�Ĳ�������
             <property name="jdbcType" value=""/>
             -->

             <!-- �ο�tableԪ�ص�delimitAllColumns���ã�Ĭ��Ϊfalse
             <property name="delimitedColumnName" value=""/>
              -->
         </columnOverride>

         <!-- ignoreColumn����һ��MGB���Ե��У���������˸��У���ô�����ɵ�domain�У����ɵ�SQL�У��������и��г��� 
             column:ָ��Ҫ���Ե��е����֣�
             delimitedColumnName���ο�tableԪ�ص�delimitAllColumns���ã�Ĭ��Ϊfalse

             ע�⣬һ��tableԪ���п����ж��ignoreColumnԪ��
         <ignoreColumn column="deptId" delimitedColumnName=""/>
         -->
    </table>

</context>

</generatorConfiguration>
���ˣ��͵������ˣ�������Ϊһ�������ĵ��鿴��