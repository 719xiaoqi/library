<template>
<div>
    <Card>
        <div slot="title">
            <div class="edit-head">
                <a @click="close" class="back-title">
                    <Icon type="ios-arrow-back" />返回
                </a>
                <div class="head-name">图书借阅详情</div>
                <span></span>
                <a @click="close" class="window-close">
                    <Icon type="ios-close" size="31" class="ivu-icon-ios-close" />
                </a>
            </div>
        </div>
        <Form ref="form" :model="form" :label-width="100" :rules="formValidate" label-position="left">
            <FormItem label="图书名称" prop="bookName">
                <Input v-model="form.bookName" readonly maxlength="240" show-word-limit placeholder="请输入图书名称..." style="width:570px" />
            </FormItem>
            <FormItem label="图书ISBN" prop="bookIsbn">
                <Input v-model="form.bookIsbn" readonly maxlength="240" show-word-limit placeholder="请输入图书ISBN..." style="width:570px" />
            </FormItem>
            <FormItem label="借阅人" prop="userName">
                <Input v-model="form.userName" readonly maxlength="240" show-word-limit placeholder="请输入借阅人..." style="width:570px" />
            </FormItem>
            <FormItem label="借阅时间" prop="time1">
                <Input v-model="form.time1" readonly maxlength="240" show-word-limit placeholder="请输入借阅时间..." style="width:570px" />
            </FormItem>
            <FormItem label="借阅状态" prop="status">
                <Input v-model="form.status" readonly maxlength="240" show-word-limit placeholder="请输入借阅状态..." style="width:570px" />
            </FormItem>
            <FormItem label="归还时间" prop="time2">
                <Input v-model="form.time2" readonly maxlength="240" show-word-limit placeholder="请输入归还时间..." style="width:570px" />
            </FormItem>
            <Form-item class="br">
                <!-- <Button @click="handleSubmit" :loading="submitLoading" type="primary">提交并保存</Button>
                <Button @click="handleReset">重置</Button> -->
                <Button type="dashed" @click="close">关闭</Button>
            </Form-item>
        </Form>
    </Card>
</div>
</template>

<script>
import {
    editBookBorrowing
} from "./api.js";
export default {
    name: "edit",
    components: {},
    props: {
        data: Object
    },
    data() {
        return {
            submitLoading: false,
            form: {
                bookId: "",
                bookName: "",
                bookIsbn: "",
                userName: "",
                time1: "",
                status: "",
                time2: "",
            },
            formValidate: {}
        };
    },
    methods: {
        init() {
            this.handleReset();
            this.form = this.data;
        },
        handleReset() {
            this.$refs.form.resetFields();
        },
        handleSubmit() {
            this.$refs.form.validate(valid => {
                if (valid) {
                    editBookBorrowing(this.form).then(res => {
                        this.submitLoading = false;
                        if (res.success) {
                            this.$Message.success("操作成功");
                            this.submited();
                        }
                    });
                }
            });
        },
        close() {
            this.$emit("close", true);
        },
        submited() {
            this.$emit("submited", true);
        }
    },
    mounted() {
        this.init();
    }
};
</script>

<style lang="less">
.edit-head {
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: relative;

    .back-title {
        color: #515a6e;
        display: flex;
        align-items: center;
    }

    .head-name {
        display: inline-block;
        height: 20px;
        line-height: 20px;
        font-size: 16px;
        color: #17233d;
        font-weight: 500;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .window-close {
        z-index: 1;
        font-size: 12px;
        position: absolute;
        right: 0px;
        top: -5px;
        overflow: hidden;
        cursor: pointer;

        .ivu-icon-ios-close {
            color: #999;
            transition: color .2s ease;
        }
    }

    .window-close .ivu-icon-ios-close:hover {
        color: #444;
    }
}
</style>
