import { Link } from "react-router-dom"
import HeaderLogo from "./HeaderLogo"

const HeaderLogoLink = () => {
  return (
    <Link to="/">
      <HeaderLogo />
    </Link>
  )
}

export default HeaderLogoLink