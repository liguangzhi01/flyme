package com.lgz.flyme.design.create.builder;

/**
 * @author liguangzhi
 * @date 2020/09/25 13:18
 */
public class ConstructerArg {
    private boolean isRef;
    private Class type;
    private Object arg;


    private ConstructerArg(){}

    private ConstructerArg(Builder builder){
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;

    }
    public static class Builder{
        private boolean isRef;
        private Class type;
        private Object arg;

        public Builder setRef(boolean ref) {
            isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }

        public ConstructerArg build() {
            if (!isRef) {
                if (type == null) {
                    throw new IllegalArgumentException("type can not be null");
                }
            } else {
                if((arg instanceof String)) {
                    throw new IllegalArgumentException("arg must be intance of String when isRef is true");
                }
            }
            if (arg == null) {
                throw new IllegalArgumentException("arg can not be null");
            }

            return new ConstructerArg(this);
        }
    }
}





    //当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；当 isRef 为 false 的时候，arg、type 都需要设置