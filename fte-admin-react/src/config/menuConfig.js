// 配置需要展示在侧边栏的项，目前只支持2级，多级需要修改路由部分、面包屑部分
const menuConfig = [
    {
        title: '首页',
        key: '/',
        icon: 'home'
    },
    {
        title: '系统管理',
        key: '/system',
        icon: 'setting',
        children: [
            {
                title: '角色管理',
                key: '/system/role',
            },
            {
                title: '菜单管理',
                key: '/system/menu',
            },
            {
                title: '用户管理',
                key: '/system/user',
            },
        ]
    },
    {
        title: '组件',
        key: '/tool',
        icon: 'build',
        children: [
            {
                title: '富文本',
                key: '/tool/rich',
            }
        ]
    }
];

export default menuConfig;
