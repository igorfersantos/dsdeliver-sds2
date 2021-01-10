import './styles.css'
import {ReactComponent as Github} from './github.svg';
import {ReactComponent as Linkedin} from './linkedin.svg';
import {ReactComponent as Discord} from './discord.svg';

//Github, Linkedin, Discord
function Footer() {
    return(
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
              <a href="https://github.com/igorfersantos/dsdeliver-sds2" target="_new">
                <Github />
              </a>

              <a href="https://www.linkedin.com/in/igorferlimeira/" target="_new">
                <Linkedin />
              </a>

              <a href="https://discord.gg/GsuT5C2cJ9" target="_new">
                <Discord />
              </a>
            </div>
        </footer>
    )
}

export default Footer;