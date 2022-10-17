                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           bpackage cn.wolfcode.service;

import cn.wolfcode.entity.T_Role;

public interface RoleService {
  T_Role getRoleInfo(String rid);
  void updateRoleInfo(T_Role role);

  T_Role getRoleInfo1(String Stype,String str);

  void insertRoleInfo(T_Role role);
}
