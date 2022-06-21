package org.kuro.erp.config;

import com.houkunlin.system.dict.starter.bean.DictTypeVo;
import com.houkunlin.system.dict.starter.provider.DictProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class MyDictProvider implements DictProvider {

    @Override
    public boolean isStoreDictType() {
        return true;
    }

    @Override
    public Iterator<DictTypeVo> dictTypeIterator() {
        // todo 使用数据库的字典数据
        List<DictTypeVo> list = new ArrayList<>();
        DictTypeVo t1 = DictTypeVo.newBuilder("gender", "性别").add("1", "男").build();
        DictTypeVo t2 = DictTypeVo.newBuilder("gender", "性别").add("2", "女").build();

        DictTypeVo t3 = DictTypeVo.newBuilder("status", "数据状态")
                .add("0", "启用").add("1", "禁用").build();

        DictTypeVo t4 = DictTypeVo.newBuilder("needs", "是否送货")
                .add("1", "送货").add("2", "自提").build();

        DictTypeVo t5 = DictTypeVo.newBuilder("del_flag", "删除状态")
                .add("1", "删除").add("0", "正常").build();

        DictTypeVo t6 = DictTypeVo.newBuilder("emp_state", "员工状态")
                .add("1", "在职").add("2", "离职").build();

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        return list.stream().iterator();
    }
}
