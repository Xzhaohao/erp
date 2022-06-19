
// 快捷访问
const getters = {
  token: (state: any) => state.user.token,
  hasUserInfo: (state: any) => JSON.stringify(state.user.userInfo) !== '{}',
  // userInfo: (state: any) => state.user.userInfo,
  sidebarOpened: (state: any) => state.app.sidebarOpened,
  tagsViewList: (state: any) => state.app.tagsViewList
}

export default getters
